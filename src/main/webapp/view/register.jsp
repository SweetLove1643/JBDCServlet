<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "jakarta.tags.core" %>
<!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Registrasion Page </title>  
</head>    
<body>    
    <!-- BEGIN CONTENT -->
    
    <div class="main">
      <div class="container">
          <div class="col-md-9 col-sm-9">
            <h1>Tạo tài khoản</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form action="/register" method="post" class="form-horizontal" role="form">
                    <fieldset>
                      <legend>Thông tin cá nhân của bạn</legend>
                      <div class="form-group">
                        <label for="firstname" class="col-lg-4 control-label" >Username <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="firstname" name="uname">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="email" class="col-lg-4 control-label" >Email <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="email" name="email">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="firstname" class="col-lg-4 control-label" >Tên đầy đủ <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="firstname" name="fname">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="firstname" class="col-lg-4 control-label" >Số điện thoại<span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="firstname" name="phone">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="firstname" class="col-lg-4 control-label" >Hình ảnh <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="firstname" name="images">
                        </div>
                      </div>
                      
                      
                      
                    </fieldset>
                    <fieldset>
                      <legend>Mật khẩu</legend>
                      <div class="form-group">
                        <label for="password" class="col-lg-4 control-label" >Password <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="password" name="pwd">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="confirm-password" class="col-lg-4 control-label">Confirm password <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" class="form-control" id="confirm-password" name="cfpwd">
                        </div>
                      </div>
                    </fieldset>
                  
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">                        
                        <button type="submit" class="btn btn-primary">Create an account</button>
                        <button type="button" class="btn btn-default">Cancel</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed sit nonumy nibh sed euismod ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip  commodo quat.</p>

                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          </div>
          </div>
          <!-- END CONTENT -->
</body>     
</html> 