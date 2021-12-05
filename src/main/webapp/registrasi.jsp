

<%@include file="templates/header_costumer.jsp" %>
<div class="container mt-3">
    <div class="row">
        <div class="col-lg-6">
            <h2 class="primary-header">Daftar Akun</h2>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <form method="POST" action="${pageContext.servletContext.contextPath}/user/daftar">
                <div class="mb-3">
                    <label for="nama" class="form-label">Nama</label>
                    <input type="text" name="nama" class="form-control"  id="nama" autocomplete="off">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="text" name="email" class="form-control"  id="email" autocomplete="off">
                </div>
                <div class="mb-3">
                    <label for="nomor_handphone" class="form-label">Nomor Handphone</label>
                    <input type="text" name="nomor_handphone" class="form-control" id="nomor_handphone" autocomplete="off">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" name="password"  class="form-control" id="password" autocomplete="off">
                </div>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-primary" type="submit">Daftar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="templates/footer_costumer.jsp" %>
