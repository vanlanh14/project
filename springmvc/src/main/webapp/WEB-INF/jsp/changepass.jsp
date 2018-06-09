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
            <div class="modal-header">
                <h3>Change Password. Username:
                    <label id="username">
                       <%= session.getAttribute("username") %>
                    </label>
                    <span class="extra-title muted"></span>
                </h3>
            </div>
           <form action="changepass/authenticate" method="POST">
            <div class="modal-body form-horizontal">
                <div class="control-group">
                    <label for="current_password" class="control-label">Current Password</label>
                    <div class="controls">
                        <input type="password" id="current_password" name="current_password">
                    </div>
                </div>
                <div class="control-group">
                    <label for="new_password"  class="control-label">New Password</label>
                    <div class="controls">
                        <input type="password" id="new_password" name="new_password">
                    </div>
                </div>
                <div class="control-group">
                    <label for="confirm_password"  class="control-label">Confirm Password</label>
                    <div class="controls">
                        <input type="password" id="confirm_password" name="confirm_password">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button href="#" class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                <button onclick="changePassword()" class="btn btn-primary"id="password_modal_save">Save changes</button>
            </div>
        </div>
	</form>

 </body>

</html>