
<%@page import="com.java.web.config.FlashMessage"%>
<%@page import="java.util.List"%>
<%@page import="com.java.web.domain.Motor"%>
<%@page import="com.java.web.service.MotorService"%>
<%

    MotorService motorService = new MotorService();
    String nomorPolisi = request.getParameter("nomor_polisi");
    List<Motor> daftarMotor = motorService.findById(nomorPolisi);
    for (Motor m : daftarMotor) {


%>


<%@include file="../../templates/header.jsp" %>
<%    FlashMessage flashMessage = (FlashMessage) session.getAttribute("msg");
    if (flashMessage != null) {
%>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <div class="alert <%=flashMessage.getCssClass()%>" role="alert">
                <%= flashMessage.getContent()%>
            </div>
        </div>
    </div>
</div>

<%
        session.removeAttribute("msg");
    }
%>
<div class="container mt-3">
    <div class="row">
        <div class="col-lg-6">
            <h2 class="primary-header">Edit data</h2>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg">
            <form action="${pageContext.servletContext.contextPath}/motor/ubah" method="POST" enctype="multipart/form-data">
                <div class="mb-3 row">                         
                    <div class="col-sm-10">
                        <input type="hidden" value="<%=m.getNomorPolisi()%>" name="nomor_polisi" class="form-control">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="type" class="col-sm-2 col-form-label">Type</label>
                    <div class="col-sm-10">
                        <input type="text" value="<%=m.getType()%>" name="type" class="form-control" id="type" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="warna" class="col-sm-2 col-form-label">Warna</label>
                    <div class="col-sm-10">
                        <input type="text" value="<%=m.getWarna()%>" name="warna" class="form-control" id="warna" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="tahun_perakitan" class="col-sm-2 col-form-label">Tahun Perakitan</label>
                    <div class="col-sm-10">
                        <input type="text" value="<%=m.getTahunPerakitan()%>" name="tahun_perakitan" class="form-control" id="tahun_perakitan" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="jenis" class="col-sm-2 col-form-label">Jenis</label>
                    <div class="col-sm-10">
                        <input type="text" value="<%=m.getJenis()%>" name="jenis" class="form-control" id="jenis" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="nomor_mesin" class="col-sm-2 col-form-label">Nomor Mesin</label>
                    <div class="col-sm-10">
                        <input type="text" value="<%=m.getNomorMesin()%>" name="nomor_mesin" class="form-control" id="nomor_mesin" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="nomor_rangka" class="col-sm-2 col-form-label">Nomor Rangka</label>
                    <div class="col-sm-10">
                        <input type="text" value="<%=m.getNomorRangka()%>" name="nomor_rangka" class="form-control" id="nomor_rangka" required="">
                    </div>
                </div>
                    <div class="mb-3 row">
                    <label for="gambar" class="col-sm-4 col-form-label">Gambar</label>
                    <div class="col-sm">
                         <img class="img-preview img-fluid col-sm-5 d-block" alt="">
                        <input type="file" onchange="previewImage()" name="gambar" class="form-control" autocomplete="off" id="gambar" required="">
                    </div>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Ubah</button>
                </div>
            </form>
        </div>
    </div>
</div>   

<% }%>
<script>
    function previewImage() {
        const gambar = document.querySelector('#gambar');
        const imgPreview = document.querySelector('.img-preview');
        imgPreview.style.display = 'block';

        const ofReader = new FileReader();
        ofReader.readAsDataURL(gambar.files[0]);

        ofReader.onload = function(oFREvent) {
            imgPreview.src = oFREvent.target.result;
        };
    };
</script>

