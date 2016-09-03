<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/template/header.jsp" %>


        <!-- Carousel
        ================================================== -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg" />" alt="First slide">
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg" />" alt="Second slide">
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="<c:url value="/resources/images/back3.jpg" />" alt="Third slide">
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->


        <!-- Marketing messaging and featurettes
        ================================================== -->
        <!-- Wrap the rest of the page in another container to center all the content. -->

		<div class="container marketing">
    	<div class="container">
    	<!-- Three columns of text below the carousel -->
            <h2>We Serve</h2>
            <div class="row">
                <div class="col-lg-4">
                   
                        <img class="img-circle" src="<c:url value="/resources/images/nepali.jpg"/>" alt="Instrument Image" width="140" height="140">
                    

                    <h2>Nepali</h2>

                </div>



                <div class="col-lg-4">
                  
                        <img class="img-circle" src="<c:url value="/resources/images/indian.jpg"/>" alt="Instrument Image" width="140" height="140">
                  

                    <h2>Indian</h2>

                </div>


                <div class="col-lg-4">
                        <img class="img-circle" src="<c:url value="/resources/images/italian.jpg"/>" alt="Instrument Image" width="140" height="140">
               

                    <h2>Italian</h2>

                </div>
            </div>
            <hr/>
           
<%@ include file="/WEB-INF/views/template/footer.jsp" %>
