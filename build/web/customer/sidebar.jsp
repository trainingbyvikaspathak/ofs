<ul class="navbar-nav bg-success sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">${customer.name}'s Dashboard</div>
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
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOrder" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Manage Orders </span>
        </a>
        <div id="collapseOrder" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Orders Details :</h6>
            <a class="collapse-item" href="viewBooked.jsp">View Pending/Booked<br/> Orders</a>
            <a class="collapse-item" href="viewCancelled.jsp">View Cancelled Orders</a>
            <a class="collapse-item" href="trackOrder.jsp">Track Order</a>
            <a class="collapse-item" href="return1.jsp">Return Product</a>
           </div>
        </div>
      </li>
      
      <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
          <i class="fas fa-fw fa-cog"></i>
          <span>Manage Account </span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <h6 class="collapse-header">Customise Profile</h6>
            <a class="collapse-item" href="viewSellers.jsp">Update Profile</a>
            <a class="collapse-item" href="#"> Add new Address</a>
            <a class="collapse-item" href="updateSeller.jsp">Change Password</a>
          </div>
        </div>
      </li>

      <!-- Nav Item - Utilities Collapse Menu -->
       <!-- Divider -->
      <hr class="sidebar-divider">

      <!-- Heading -->
      <div class="sidebar-heading">
        Addons
      </div>

      <!-- Nav Item  Pages Collapse Menu -->
   

      <!-- Nav Item - Charts -->
      <li class="nav-item">
          <a class="nav-link" href="viewQueries.jsp">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>View Replies</span></a>
      </li>

      <!-- Nav Item - Tables -->
       

      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">

          


    </ul>

