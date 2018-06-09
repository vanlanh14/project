<%@ page session="true" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Change password Page</title>

         <script src="javascript/jquery-3.3.1.min.js"></script>
         <script src="javascript/bootstrap.min.js"></script>

         <link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css">

    </head>
    <body class="text-center">
        <div class="modal" id="password_modal" style="display:block;">
           <form action="signup/authenticate" method="POST">
            <div class="modal-body form-horizontal">
                <div class="control-group">
                   <label for="usename" class="control-label">Username</label>
                    <div class="controls">
                         <input type="text" id="username" name="username">
                    </div>
                 </div>
                <div class="control-group">
                    <label for="fullname" class="control-label">Fullname</label>
                    <div class="controls">
                        <input type="text" id="fullname" name="fullname">
                    </div>
                </div>
                <div class="control-group">
                    <label for="password"  class="control-label">Password</label>
                    <div class="controls">
                        <input type="password" id="password" name="password">
                    </div>
                </div>
                <div class="control-group">
                    <label for="confirm_password"  class="control-label">Confirm Password</label>
                    <div class="controls">
                        <input type="password" id="confirm_password" name="confirm_password">
                    </div>
                </div>
            </div>
            <button type="submit">Signup</button>
        </div>
	</form>

 </body>

</html>