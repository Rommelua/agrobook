<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=cp1251"%>
<%@ page pageEncoding="cp1251"%>

<html>
<head>
</head>

<body>
	<b id="sort" onclick="sortTable()">Book Shelter</b>
	<br>
	<table id="table">
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}. </td>
				<td>${book.bookname}</td>
				<td>&nbsp; ${book.dateofbook}</td>
			</tr>
		</c:forEach>
	</table>
	<h4 style="color: red">${message}</h4>
	<form method="post" action="${pageContext.request.contextPath}">
		<div class="form-group">
			<label class="col-form-label" for="name">Name:</label><br/>
			<input class="form-control" size="30px" id="name" name="name" type="text" required="required" >
		</div>
		<br/>
		<button style="color: #2cffb8; border-radius: 5px" type="submit">Add book</button>
	</form>

</body>
<script>
	function sortTable() {
		var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
		table = document.getElementById("table");
		switching = true;
		// Set the sorting direction to ascending:
		dir = "asc";
		/* Make a loop that will continue until
        no switching has been done: */
		while (switching) {
			// Start by saying: no switching is done:
			switching = false;
			rows = table.rows;
			/* Loop through all table rows (except the
            first, which contains table headers): */
			for (i = 0; i < (rows.length - 1); i++) {
				// Start by saying there should be no switching:
				shouldSwitch = false;
				/* Get the two elements you want to compare,
                one from current row and one from the next: */
				x = rows[i].getElementsByTagName("TD")[1];
				y = rows[i + 1].getElementsByTagName("TD")[1];
				/* Check if the two rows should switch place,
                based on the direction, asc or desc: */
				if (dir == "asc") {
					if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
						// If so, mark as a switch and break the loop:
						shouldSwitch = true;
						break;
					}
				} else if (dir == "desc") {
					if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
						// If so, mark as a switch and break the loop:
						shouldSwitch = true;
						break;
					}
				}
			}
			if (shouldSwitch) {
				/* If a switch has been marked, make the switch
                and mark that a switch has been done: */
				rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
				switching = true;
				// Each time a switch is done, increase this count by 1:
				switchcount ++;
			} else {
				/* If no switching has been done AND the direction is "asc",
                set the direction to "desc" and run the while loop again. */
				if (switchcount == 0 && dir == "asc") {
					dir = "desc";
					switching = true;
				}
			}
		}
	}
</script>
</html>