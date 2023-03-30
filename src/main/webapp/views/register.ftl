
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="signup-form" id="registerform" >


		<!-- form header -->
		<div class="form-header">
			<h1>Register</h1>
		</div>

		<!-- form body -->
		<div class="form-body">
		

			<!-- Firstname and Lastname -->
			<div class="horizontal-group">
				<div class="form-group left">
					<label for="first_name" class="label-title">First name *</label> <input
						 id="firstname" name="firstname"
						class="form-input"
						placeholder="enter your first name" />


				</div>
				<div class="form-group right">
					<label for="lastname" class="label-title">Last name</label> <input
						type="text"  
				 id="lastname" name="lastname" class="form-input"
						placeholder="enter your last name" />
				</div>
			</div>

			<!-- Dob and Phone no -->
			<div class="horizontal-group">
				<div class="form-group left">
					<label for="Date" class="label-title"> DOB </label> <input
						type="date" id="datepicker"  class="form-input" name="dob" placeholder="enter your DOB">
				</div>
				<div class="form-group right">
					<label for="phone no" class="label-title">Phone No</label> <input
						type="number"  class="form-input" id="phoneno"
						placeholder="enter your phone no" name="mobileno"
						required="required">
				</div>
			</div>


			<!-- Email -->
			<div class="form-group">
				<label for="email" class="label-title">Email*</label> <input
					type="email" path="email" id="email" name="email"
					class="form-input"
					placeholder="enter your email">

			</div>

			<!-- Passwrod and confirm password -->
			<div class="horizontal-group">
				<div class="form-group left">
					<label for="password" class="label-title">Password *</label> <input
					 type="password" id="password" class="form-input" name="password"
						placeholder="enter your password" required="required">
				</div>
				<div class="form-group right">
					<label for="confirm-password" class="label-title">Confirm
						Password *</label> <input type="password" class="form-input"
						path="passwordConfirm" id="cpassword" name="passwordConfirm"
						placeholder="enter your password again" required="required">

				</div>
			</div>
			<!-- Gender and Hobbies -->

			<div class="horizontal-group">
				<div class="form-group left">
					<label class="label-title">Gender:</label>
					<div class="input-group">
						<label for="male"><input type="radio" name="gender"
							path="gender" value="male" id="male"> Male</label> <label
							for="female"><input path="gender" type="radio"
							name="gender" value="female" id="female"> Female</label>
					</div>
				</div>
				<div class="form-group right">
					<label class="label-title">Hobbies</label>
					<div>
						<select class="form-control" id="hobby" name="hobby">
							<option value="not" name="hobby">Select Hobby</option>
							<option value="Cricket">Cricket</option>
							<option value="BasketBall">BasketBall</option>
							<option value="Hockey">Hockey</option>
						</select>
					</div>
				</div>
			</div>

			<!-- Profile picture and Age -->
			<div class="form-group">
				<div id="form-group left">
					<label for="choose-file" class="label-title">Upload Profile
						Picture</label> <input type="file" path="image" name="image"
						id="choose-file">
				</div>
			</div>


			<div class="addresses">
				<div class="form-group address-section">
					<label for="address">Address :</label> <label class="control-label"
						for="address_line_one_0">Address line 1</label> <input type="text"
						id="address_line_one_0" class="form-control addresstest"
						name="Address[0].Address1" maxlength="255">

					<div class="add-style">
						<span> <label class="control-label"
							for="address_line_one_0">city</label> <select
							class="form-control" id="city" name="Address[0].city">
								<option value="not">Select City</option>
								<option value="Pune">pune</option>
								<option value="Ahmedabad">Ahmedabad</option>
								<option value="Surat">Surat</option>
								<option value="Amreli">Amreli</option>
						</select></span> <span> <label class="control-label" for="country">State</label>
							<select class="form-control" name="Address[0].state" id="state">
								<option value="not">Select State</option>
								<option value="Gujarat">Gujarat</option>
								<option value="Mumbai">Mumbai</option>
								<option value="MP">MP</option>
								<option value="UP">UP</option>
						</select>
						</span> <span> <label class="control-label" for="city_0">Area</label>
							<input type="text" id="city_0" class="form-control"
							name="Address[0].area" maxlength="64">

						</span> <span> <label class="control-label" for="city_0">Postal
								code</label> <input type="number" id="state_0" class="form-control"
							name="Address[0].postalcode" maxlength="64">
						</span> <span> <a href="javascript:void(0);"
							class="list_remove_button btn btn-danger">Remove</a></span>
					</div>
				</div>
				</#list>
			</div>
			<div>
					<a href="javascript:void(0);" class="Add_add_button">Add more address</a>
				</div>
			
			<!-- form-footer -->
			<div class="form-footer">
				<span>* required</span>
				<button type="submit" id="Rbtn" class="btn">Create</button>
			</div>
	</form>


	</body>
</html>