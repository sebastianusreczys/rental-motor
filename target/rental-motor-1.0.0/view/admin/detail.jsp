
<%@page import="java.util.List"%>
<%@page import="com.java.web.domain.Motor"%>
<%

    List<Motor> motor = (List<Motor>) request.getAttribute("detailMotor");
    for (Motor m : motor) {
%>


<%@include file="../../templates/header.jsp" %>

<div class="container mt-4">
    <h3>Detail Motor</h3>
    <div class="row">
        <div class="col-lg-6">
            <div class="card">
                <div class="card-body text-field">
                    <h5 class="card-title">Nomor Polisi : <%= m.getNomorPolisi()%></h5>
                    <p class="card-text">Type   :   <%=m.getType()%></p>
                    <p class="card-text">Warna  :   <%=m.getWarna()%></p>
                    <p class="card-text">Tahun Perakitan : <%=m.getTahunPerakitan()%></p>
                    <p class="card-text">Nomor Mesin : <%=m.getNomorMesin()%></p>
                    <p class="card-text">Nomor Rangka : <%=m.getNomorRangka()%></p>    
                    <img src="../img/<%=m.getGambar()%>">
                </div>

            </div>
        </div>
        <div class="container mt-2">
        <div class="row">
            <div class="col-lg-4">
                <a href="http://localhost:8081/rental-motor/" class="btn btn-primary">Kembali</a>
            </div>
        </div>
        </div>
    </div>
</div>
<%}%>

<%@include file="../../templates/footer.jsp" %>