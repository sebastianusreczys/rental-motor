

<%@page import="com.java.web.config.FlashMessage"%>
<%@include file="../../templates/header.jsp" %>



<div class="container mt-3">
    <div class="row">
        <div class="col-lg-6">
            <h2 class="primary-header">Tambah data</h2>
        </div>
    </div>
</div>



<%

    FlashMessage flashMessage = (FlashMessage) session.getAttribute("msg");
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
            <form id="add-post-form" action="${pageContext.servletContext.contextPath}/motor/add" method="POST" enctype="multipart/form-data">
                <div class="mb-3 row">
                    <label for="nomor_polisi" class="col-sm-4 col-form-label">Nomor Polisi</label>
                    <div class="col-sm">
                        <input type="text" name="nomor_polisi" class="form-control" 
                               id="nomor_polisi" required="" autocomplete="off">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="type" class="col-sm-4 col-form-label">Type</label>
                    <div class="col-sm">
                        <input type="text" name="type" class="form-control" autocomplete="off" id="type" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="warna" class="col-sm-4 col-form-label">Warna</label>
                    <div class="col-sm">
                        <input type="text" name="warna" class="form-control" autocomplete="off" id="warna" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="tahun_perakitan" class="col-sm-4 col-form-label">Tahun Perakitan</label>
                    <div class="col-sm">
                        <input type="text" name="tahun_perakitan" class="form-control" autocomplete="off" id="tahun_perakitan" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="jenis" class="col-sm-4 col-form-label">Jenis</label>
                    <div class="col-sm">
                        <input type="text" name="jenis" class="form-control" autocomplete="off" id="jenis" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="nomor_mesin" class="col-sm-4 col-form-label">Nomor Mesin</label>
                    <div class="col-sm">
                        <input type="text" name="nomor_mesin" class="form-control" autocomplete="off" id="nomor_mesin" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="nomor_rangka" class="col-sm-4 col-form-label">Nomor Rangka</label>
                    <div class="col-sm">
                        <input type="text" name="nomor_rangka" class="form-control" autocomplete="off" id="nomor_rangka" required="">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="gambar" class="col-sm-4 col-form-label">Gambar</label>
                    <div class="col-sm">
                         <img class="img-preview img-fluid col-sm-5 d-block" alt="">
                        <input type="file" onchange="previewImage()" name="gambar" class="form-control" autocomplete="off" id="gambar" required="">
                    </div>
                </div>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-primary" type="submit">Tambah</button>
                </div>
            </form>
        </div>
    </div>
</div>   
<%@include file="../../templates/footer.jsp" %> 
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous">
</script>

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


<!--<script type="text/javascript">
    $(document).ready(function (e) {
        $("#add-post-form").on('submit', function (event) {
            event.preventDefault();
            console.log("Sudah klik submit");
            let data = FromData(this);
            $.ajax({
                url: "TambahMotorController",
                type: 'POST',
                data: data,
                success: function (data, textStatus, jqXHR) {
                    console.log(data);
                    if (data.trim() === 'done') {
                        swal("Success!", "Berhasil tambah data!", "success");
                        window.location("index.jsp");
                    } else
                    {
                        swal("Error", "Gagal tambah data!", "error");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    swal("Error", "Gagal tambah data!", "error");
                },
                processData: false,
                contentType: false

            });
        });
    });
</script>-->

