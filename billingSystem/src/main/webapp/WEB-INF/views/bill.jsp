<%@ include file="/WEB-INF/views/template/header.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page import ="java.text.DateFormat"%>
<%@ page import ="java.text.SimpleDateFormat"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript" src="<c:url value='/resources/js/helper.js'/>"></script>
<script type="text/javascript">
function change(sel){
		var $row=$(this).parent().find('td');
		
		/* alert(sel.value);
		document.getElementById('quantity[]').value=sel.value; */
		 $.ajax({
		        type: "GET",
		        url: "../user/getdata",
		        data:{value:sel.value},
		        dataType: "json",
		        contentType: "application/json",
		        success: function (unitPrice) {
		        	sel.parentNode.parentNode.cells[3].childNodes[0].value = unitPrice;
		        },
		        error: function () {
		            alert("failure");
		        }
		    });
	}
</script>
 
    <!-- font icon -->
    
    <link href="../resources/css/font-awesome.min.css" rel="stylesheet" />    
<div class="row">
				<div class="col-lg-12">
					<ol class="breadcrumb">
						<li><i class="fa fa-home"></i><a href="../user/default">Home</a></li>
						<li><i class="fa fa-laptop"></i>Add Bills</li>						  	
					</ol>
				</div>
			</div>
<div class="container">
	<form class="form-horizontal" action="../user/bill" method="post" modelAttribute="bill">
		<fieldset>

			<!-- Form Name -->
			<legend>Add Bill</legend>
			<div class="row">
				<div class="col-md-3"></div>

				<div class="col-md-9">
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="billNo">Bill#</label>
						<div class="col-md-4">
							<input path="billno" name="billno" type="text"
								class="form-control input-md" value="${billNumber}" readonly="true"/>

						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3"></div>

				<div class="col-md-9">
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="billno">Bill
							Date</label>
						<div class="col-md-4">
							<input path="billDate" name="billDate" type="text" readonly="true"
								class="form-control input-md" value="<%
										out.print(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));%>"/>

						</div>
					</div>
				</div>
			</div>
        
			<table class="table" id="dataTable">
				<thead>
					<tr>
						<th></th>
						<th>Item</th>
						<th>Description</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tr>
					<td> <img class="img-circle" src="<c:url value="/resources/help/delete_item.gif"/>" alt="Delete Item" onclick="deleteRow(this,'dataTable')" /></td>
					<td><select path="item" id="item[]" name="item[]"
						class="form-control" onchange="change(this);"><option value="NONE">--Select--</option>
						<c:forEach var="item" items="${items}">
     					<option value="${item}">${item}</option>
    					</c:forEach>
						</select></td>
					<td><textarea path="description" name="description[]"
							id="description" placeholder="" class="form-control input-md"
							value=" " rows="1" cols="40"></textarea></td>
					<td><input path="unit_price" name="unit_price[]"
						id="unit_price[]" type="text" placeholder="0.00"
						class="form-control input-md"
						onFocus="if (this.value=='0.00') {this.value = '';this.style.color = '#3c3c3c';}"
						value="0.00" onBlur="reCalculate(this, 'dataTable', this.value);" readonly="true"/></td>
					<td><input path="quantity" name="quantity[]" id="quantity[]"
						type="text" placeholder="0.00" class="form-control input-md"
						onFocus="if (this.value=='0.00') {this.value = '';this.style.color = '#3c3c3c';}"
						value="0.00" onBlur="reCalculate(this, 'dataTable', this.value);" /></td>
					<td><input path="amount" name="amount[]" id="amount[]"
						type="text" placeholder="0.00" class="form-control input-md"
						value="0.00" readonly="true"/></td>
				</tr>

			</table>
	
			<input type="button" value="Add Item" onclick="addRow('dataTable')"
				class="btn btn-success" />
				
			<table class="table">
				<tr>
						<td colspan="5" style="text-align: left;">Notes</td>
						
					</tr>
				<tr>
					<td rowspan="8" colspan="3"><textarea name="notes" id="notes" rows="9" cols="50" readonly="readonly">${note}</textarea></td>
					<td>SubTotal</td>
					<td><input type="text" path="sum_subtotal" id="sum_subtotal" name="sum_subtotal" value="0.00" class="form-control input-md" readonly="true"/></td>
					</tr>
					<tr>
					<td>+ Service Tax (%)</td>
					<td> <input id="service_tax" path="service_tax" name="service_tax" class="form-control input-md" onFocus="if (this.value=='0.00') {this.value = '';this.style.color = '#3c3c3c';}"
						value="0.00" onBlur="reCalculate(this, 'dataTable', this.value);" /></td>
					 
					</tr>
					<tr>
					<td>- Discount</td>
					<td><input id="sum_discount"  type="text" path="sum_discount" name="sum_discount" onFocus="if (this.value=='0.00') {this.value = '';this.style.color = '#3c3c3c';}"
						value="0.00" onBlur="reCalculate(this, 'dataTable', this.value);" class="form-control input-md"/></td>
				</tr>
				<tr>
					<td>Total</td>
					<td> <input type="text" path="sum_total" name="sum_total" id="sum_total" value="0.00" class="form-control input-md" readonly="true"/></td>
				</tr>

			</table>	
			<!-- Register Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-8">
					<button id="printbill" class="btn btn-success" disabled>Print</button>
					<button id="savebill" class="btn btn-success">Save</button>
				</div>
			</div>
		</fieldset>
		</form>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>