<ul class="navbar-nav bg-success sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">${admin.name}'s Dashboard</div>
      </a>

      <!-- Divider -->
      <hr class="sidebar-divider my-0">

      <!-- Nav Item - Dashboard -->
      <li class="nav-item active">
        <a class="nav-link" href="adminhome.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Manage Sellers </span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Customise Sellers</h6>
            <a class="collapse-item" href="viewSellers.jsp">View Sellers</a>
            <a class="collapse-item" href="updateSeller.jsp">Update Seller's Status</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Manage Products</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Customise Products </h6>
            <a class="collapse-item" href="showProducts.jsp">View All Products</a>
            <a class="collapse-item" href="updateProducts.jsp">Pending/Rejected Product<br/>(Update Status)</a>
          </div>
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOrder" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Manage Orders </span>
        </a>
        <div id="collapseOrder" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Orders Details :</h6>
            <a class="collapse-item" href="viewBooked.jsp">View Pending/Booked Orders</a>
            <a class="collapse-item" href="viewCancelled.jsp">View Cancelled Orders</a>
            <a class="collapse-item" href="viewReturnProduct.jsp">View Returned Orders</a>
            <a class="collapse-item" href="updateOrderStatus.jsp">Change Order Status</a>
                     
          </div>
        </div>
      </li>

      <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Addons
      </div>

      <!-- Nav Item - Pages Collapse Menu -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
          <i class="fas fa-fw fa-folder"></i>
          <span>Pages</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Login Screens:</h6>
             <a class="collapse-item" href="addCategory.jsp">Add Category of Products</a>
              <a class="collapse-item" href="addWeartype.jsp">Add Weartpye of Products</a>
            <a class="collapse-item" href="#">Add Admin</a>
            <a class="collapse-item" href="#">Remove Admin</a>
            <a class="collapse-item" href="forgot-password.html">Forgot Password</a>
             
          </div>
        </div>
      </li>

      <!-- Nav Item - Charts -->
      <li class="nav-item">
          <a class="nav-link" href="viewQueries.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Queries</span></a>
      </li>

      <!-- Nav Item - Tables -->
       

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

          


    </ul>

