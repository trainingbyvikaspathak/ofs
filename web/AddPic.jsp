<%-- 
    Document   : AddPic
    Created on : Jun 19, 2020, 4:59:38 PM
    Author     : Arpit mishra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Profile Pic</title>
        <jsp:include page="base.jsp"></jsp:include>
        <script type="text/javascript"> 
            
               function readURL(input) {
                   
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                   preview.src= e.target.result;
                };

                reader.readAsDataURL(input.files[0]);
            }
        }
      </script>

    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col col-md-6">
                    <center>
               <form action="CustomerController?op=add" method="post" enctype="multipart/form-data" class="form">
                       <h4>Upload Profile Image </h4>
                       <img src="../img/nopic.png" style="width:300px;height: 300px" class="img img-thumbnail" id="preview"/> <br/>
                       <input type="file" name="photo" class="form-control bg-dark" onchange="readURL(this);"/><br/>
                       <input type="submit" value="Register Me" class="btn btn-primary form-control"/>
                   </form>
                   <br/>
                   <a href="register.jsp" class="btn btn-success" > Check previous data</a>
              
               
                    </center>
                </div>
            </div>
        </div>
         
         
    </body>
</html>
