function addRow(tableID) {

		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var colCount = table.rows[1].cells.length;
        
		for (var i = 0; i < colCount; i++) {

			var newcell = row.insertCell(i);
			newcell.innerHTML = table.rows[(rowCount - 1)].cells[i].innerHTML;
			newcell.className = table.rows[(rowCount - 1)].cells[i].className;
			
			var inputNode = newcell.getElementsByTagName("input")[0];
			if (inputNode) {

				var temp = $(inputNode);
				if (temp.attr('type') == 'hidden') {
					inputNode.value = '';
				} else {
					inputNode.value = '0.00';
				}

			}

			var selectNode = newcell.getElementsByTagName("select")[0];
			if (selectNode) {
				selectNode.selectedIndex = 0;
			}

			var textareaNode = newcell.getElementsByTagName("textarea")[0];
			if (textareaNode) {
				textareaNode.value = '';
				textareaNode.rows = 1;
			}

		}
	}

	function deleteRow(from, tableID) {
	    var node = from;
	    var table = document.getElementById(tableID);
	    var rowCount = table.rows.length;
	    while ( node != null )    {
	        if (node.tagName == "TR" ) 	{

		        if(rowCount <= 2) { 
					alert("Cannot delete all the rows.");
	       		    break;
	       		} else {
	                setDeleted(tableID, node.rowIndex);
		            reCalculateDeleteRow(node.rowIndex);
	   	    	    table.deleteRow(node.rowIndex);
	   	    	    reCalculate(document.getElementById('sum_discount'),'dataTable','0.00');

	       			return;
	       		}
	   		}
	   		node = node.parentNode;
		}
	}
	
	function reCalculateDeleteRow(rowIndex) {
		//recalculates sum_subtotal, sum_total and balance_due when a row has been deleted. Does this by subtracting the line_total from the aforementioned variables.

		var id = (rowIndex-1);	

		//picks up the necessary variables
		var line_total = document.getElementsByName("amount[]")[id].value;
		var sum_subtotal = document.getElementsByName('sum_subtotal')[0].value;

		//recalculates the sum_subtotal, tax and balance_due
		sum_subtotal = sum_subtotal - line_total;
		
		//puts the variables back into the form
		document.getElementsByName('sum_subtotal')[0].value = sum_subtotal.toFixed(2);
	}
	
	function setDeleted(tableID, rowIndex){
	    var id = (rowIndex-1);
	    var obj = document.getElementsByName("[]")[id];

	    if (obj){
	        var Id = obj.value;

	        if (Id)
	            $(tableID).append('<input type="hidden" name="[]" value="'+Id+'">');
	    }

	}

	function checkIfEmpty(obj) {

		var new_value = obj.value;

		if (new_value == '') {
			new_value = '0.00';
			new_color = 'silver';
		}

		else {

			new_value = pad_zeros(new_value);
			new_color = '#3c3c3c';
		}

		obj.value = new_value;
		obj.style.color = new_color;
	}

	function reCalculate(obj, tableID, verdi) {

		//will use these variables if this function must run twice... i.e. when this function changes the value of the cell to 0 (when NaN input)
		var original_obj = obj;
		var original_tableID = tableID;
		var original_verdi = verdi;
      
		//will only calculate the values if it is a valid number, i.e. non-NaN	
		if (!isNaN(verdi)) {

			//declares the variables 
			var old_line_amount = 0;
			var new_line_amount = 0;

			//won't go through the lines if there's only a change in the discount
			if (obj.id != "sum_discount") {

				//declare more variables
				var table = document.getElementById(tableID);
				var rowCount = table.rows.length;
				var rowNumber = 0;
				var node = obj;

				//finds the line number the change happened at
				while (node != null) {
					if (node.tagName == "TR") {
						rowNumber = node.rowIndex;
						break;
					}
					node = node.parentNode;
				}

				var id = (rowNumber - 1);

				/* recalculates: 
				(1) gets the old line_amount
				(2) calculates the new line amount
				(3) gets the old sums 
				(4) subtracts the old line_amount from the old sums
				(5) adds the new line_amount to the sums
				 */

				old_line_amount = document.getElementsByName("amount[]")[id].value;
				new_line_amount = document.getElementsByName("unit_price[]")[id].value
						* document.getElementsByName("quantity[]")[id].value;
				document.getElementsByName("amount[]")[id].value = new_line_amount
						.toFixed(2);

			}

			//calculate sums
			var old_sum_subtotal = document.getElementsByName("sum_subtotal")[0].value;
			var new_sum_subtotal = old_sum_subtotal - old_line_amount+ new_line_amount;
			var service_tax = document.getElementsByName("service_tax")[0].value* new_sum_subtotal / 100;

			var discount = parseFloat(document.getElementsByName("sum_discount")[0].value); //multiplies with 1 to make toFixed work
			if (isNaN(discount)) discount = 0;

			//must write these back into the form because they are used by the tax recalculation below
			document.getElementsByName("sum_subtotal")[0].value = new_sum_subtotal.toFixed(2);
			document.getElementsByName("sum_discount")[0].value = discount.toFixed(2);

			 var sum_total = new_sum_subtotal - discount+service_tax;
			//writes the rest back into the form
			document.getElementsByName("sum_total")[0].value = sum_total.toFixed(2);

		} else {
			obj.style.color = 'silver';

			if (obj.id != "sum_discount") {

				obj = obj.parentNode; //input -> td
				colNo = obj.cellIndex;
				obj = obj.parentNode; //td -> tr
				rowNo = obj.rowIndex;
				rowNo = rowNo - 1;
				if (colNo == 3)
					document.getElementsByName("unit_price[]")[rowNo].value = "0.00";
				else if (colNo == 4)
					document.getElementsByName("quantity[]")[rowNo].value = "0.00";
			} else
				document.getElementsByName("sum_discount")[0].value = "0.00";

			if (!original_obj.disabled) {
				//recalculates everything after having set the NaN to 0.00
				reCalculate(original_obj, original_tableID, "0.00");

				alert(AynaxMessages.VALID_NUMBER);
			}
		}
	}
