class myHeader extends HTMLElement{
connectedCallback(){
this.innerHTML = `<header class="nav-container"> 
    <div class="nav-above">
      <span style="
      font-size: 35px;
      font-weight: bold;
      ">FU <span style="    font-style: italic;
      font-weight: bold;
      color: #4caf50;">PASS</span></span>
    </div>
   
</header>
<div class="nav-under-container" style="position: sticky; top: 0px; z-index: 100;">
  <div class="nav-under">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
       <a class="navbar-brand" href="#
       ">We are FPTers</a>
       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Trang Chủ <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Khóa Học</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Tin Tức
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <a class="dropdown-item" href="#">Action</a>
              <a class="dropdown-item" href="#">Another action</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="#">Something else here</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Đóng góp</a>
          </li>
        </ul>

        <div class="nav-account" id="nav-account">
         <div>
            <p id="user-name">Username</p>
          </div>
          <div class="account-user">
            <i class="fas fa-user"></i>
          </div>
          <div class="account-message">
            <i class="far fa-envelope"></i>
          </div>
          <div class="account-notification">
            <i class="fas fa-bell"></i>
          </div>
        </div>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Cậu muốn tìm cái gì nè" aria-label="Tìm kiếm">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
        </form>
      </div>
    </nav>
  </div>
</div>
`
}
}
customElements.define('my-header', myHeader);
        class myFooter extends HTMLElement{
        connectedCallback(){
        this.innerHTML = `<footer class="bg-primary text-white text-center text-lg-start" style="background-color: #f44336 !important;">
  <!-- Grid container -->
  <div class="container p-4">
    <!--Grid row-->
    <div class="row">
      <!--Grid column-->
      <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
        <h5 class="text-uppercase">Cộng đồng học tập của sinh viên FPT</h5>

        <p>
            Trang web được xây dựng với mục đích giao lưu học hỏi giúp đỡ giữa các bạn sinh viên với nhau thông qua những câu hỏi, những chủ đề được tạo nên từ quá trình gặp khó khăn trong việc giải quyết các bài tập và những vấn đề trên giảng đường
        </p>
      </div>
      <!--Grid column-->

      <!--Grid column-->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
        <h5 class="text-uppercase">Links</h5>

        <ul class="list-unstyled mb-0">
          <li>
            <a href="#!" class="text-white">Link 1</a>
          </li>
          <li>
            <a href="#!" class="text-white">Link 2</a>
          </li>
          <li>
            <a href="#!" class="text-white">Link 3</a>
          </li>
          <li>
            <a href="#!" class="text-white">Link 4</a>
          </li>
        </ul>
      </div>
      <!--Grid column-->

      <!--Grid column-->
      <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
        <h5 class="text-uppercase mb-0">Links</h5>

        <ul class="list-unstyled">
          <li>
            <a href="#!" class="text-white">Link 1</a>
          </li>
          <li>
            <a href="#!" class="text-white">Link 2</a>
          </li>
          <li>
            <a href="#!" class="text-white">Link 3</a>
          </li>
          <li>
            <a href="#!" class="text-white">Link 4</a>
          </li>
        </ul>
      </div>
      <!--Grid column-->
    </div>
    <!--Grid row-->
  </div>
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2020 Copyright:
    <a class="text-white" href="https://mdbootstrap.com/">FUWePass.net</a>
  </div>
  <!-- Copyright -->
</footer>`
        }
        }
customElements.define('my-footer', myFooter);
