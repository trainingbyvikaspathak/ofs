<ul class="navbar-nav bg-success sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">${shopkeeper.name}'s Dashboard</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="shopkeeperhome.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Manage Products</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Custom Products:</h6>
            <a class="collapse-item" href="addProduct.jsp">Add Product</a>
            <a class="collapse-item" href="viewProducts.jsp">View / Update Product</a>
            <a class="collapse-item" href="viewPendingProducts.jsp">Pending Products</a>
            <a class="collapse-item" href="viewApprovedProducts.jsp">Approved Products</a>
            <a class="collapse-item" href="viewRejectedProducts.jsp">Rejected Products</a>
            </div>
        </div>
      </li>
      
         

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Shopkeeper Section</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Manage Profile :</h6>
             <a class="collapse-item" href="#">View Profile</a>
              <a class="collapse-item" href="#">Edit Profile</a>
               <a class="collapse-item" href="#">Change Password</a>
               <a class="collapse-item" href="logout.jsp">Logout</a>
                 
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
     
     
      <!-- Nav Item - Charts -->
      <li class="nav-item">
          <a class="nav-link" href="viewReviews.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Queries/Reviews</span></a>
      </li>

      <!-- Nav Item - Tables -->
      <li class="nav-item">
        <a class="nav-link" href="#">
          <i class="fas fa-fw fa-table"></i>
          <span>Customers</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

          


    </ul>

