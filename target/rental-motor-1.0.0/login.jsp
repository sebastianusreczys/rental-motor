

<%@include file="templates/footer_costumer.jsp" %>

<div class="container mt-3">
    <div class="row d-flex justify-content-center">
        <div class="col-lg-6">
            <h2 class="primary-header">Form Login</h2>
        </div>
    </div>
</div>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-6">
            <form action="${pageContext.servletContext.contextPath}/user/login" method="POST">
                <div class="mb-3 row">
                    <label for="email" class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="email"  name="email" required="" class="form-control" id="email">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="password" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                        <input type="password" name="password" required="" class="form-control" id="password">
                    </div>
                </div>
                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                    <button class="btn btn-primary" type="submit">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>



            <%@include file="templates/footer_costumer.jsp" %>