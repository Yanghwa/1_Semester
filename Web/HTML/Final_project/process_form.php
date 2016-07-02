<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>Receipt</title>
		<link rel="stylesheet" href="css/styles.css" />
	</head>
	<body>
		<h1>PayPal™</h1>
		<h2>Settings Updated</h2>
<?php
	$fname = $_GET['fname'];
	$lname = $_GET['lname'];
	$address1 = $_GET['address1'];
	$address2 = $_GET['address2'];
	$province = $_GET['province'];
	$phone = $_GET['phone'];
	$email = $_GET['email'];
	$password = $_GET['password'];
	$ccnumber = $_GET['ccnumber'];
	$ccexpireyear = $_GET['ccexpireyear'];
	$ccexpiremonth = $_GET['ccexpiremonth'];

	echo('<p>Thank You, '.$fname.'&nbsp;'.$lname.'Your address is'.$address1.$address2.'.'.'Your phone number is '.$phone.'.'.'Your email is '.$email.'.'.  'your settings have been saved.</p>');
?>
	</body>
</html>
