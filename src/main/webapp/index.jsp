<%@page import="com.java.web.config.FlashMessage"%>
<%@page import="com.java.web.domain.Motor"%>
<%@page import="java.util.List"%>
<%@page import="com.java.web.service.MotorService"%>

<jsp:include page="templates/header.jsp"/>

<div class="container mt-4">
    <div class="row">
        <div class="col-lg-6">
            <a href="${pageContext.servletContext.contextPath}/motor/add" class="btn btn-primary">Tambah Data</a>
        </div>
    </div>
</div>

<%

    FlashMessage flashMessage = (FlashMessage) session.getAttribute("msg");
    if (flashMessage != null) {
%>
<div class="container mt-2">
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
            <h3 class="primary-header">Daftar Motor</h3>
            <ul class="list-group">
                <%
                    MotorService dao = new MotorService();
                    List<Motor> list = dao.daftarMotor();
                    for (Motor m : list) {
                %>
                <li class="list-group-item text-field">   
                    <%= m.getNomorPolisi()%>
                    <a href="motor/hapus?nomor_polisi=<%= m.getNomorPolisi()%>"><span class="badge m-1 bg-danger rounded-pill float-end" onclick="return confirm('yakin?')"> hapus </span></a>
                    <a href="motor/ubah?nomor_polisi=<%= m.getNomorPolisi()%>" ><span class="badge m-1 bg-success rounded-pill float-end"> update </span></a>
                    <a href="motor/detail?nomor_polisi=<%= m.getNomorPolisi()%>"><span class="badge m-1 bg-primary rounded-pill float-end"> detail </span></a>
                </li>
                <%}%>
            </ul>
        </div>
    </div>
</div>

<jsp:include page="templates/footer.jsp"/>