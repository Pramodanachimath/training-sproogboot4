<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Investment</h1>
<form action="addInvestment" method="post">
Name=<input type="text" name="planName"><br>
Entry Age=<input type="text" name="entryAge"><br>
Amount=<input type="text" name="amount"><br>
Term=<input type="text" name="term"><br>
Risk=<input type="radio" name="risk" value="low">Low
<input type="radio" name="rosk" value="high">High<br>
Purpose<select name="purpose">
<option value="Education">Education
<option value="MARRIAGE">Marriage
<option value="RETIRMENT">Retirment
<option value="SAVINGS">Savings</select> <br>
Nominee<select name="nominee">
<option value="FATHER">Father
<option value="MOTHER">Mother
<option value="SON">Son
<option value="DAUGHTER">Daughter
<option value="WIFE">Wife
</select> <br>
Type<select name="type">
<option value="Mutual Fund">Mutual Fund
<option value="Public Provident Fund">PPF
<option value="Unit Limited Investment Plan">ULIP
<option value="Fixed Deposite">FD
</select> <br>
<input
type="submit" value="Add Investment">
</form>
</body>
</html>