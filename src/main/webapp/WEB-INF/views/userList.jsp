<jsp:include page="header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="padding:30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:80%; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="color:#2d2d2d;">User List</h2>

        <table style="width:100%; border-collapse:collapse; margin-top:20px;">

            <tr style="background:#f1f2f6;">
                <th style="padding:10px; border:1px solid #ddd;">ID</th>
                <th style="padding:10px; border:1px solid #ddd;">Name</th>
                <th style="padding:10px; border:1px solid #ddd;">Email</th>
                <th style="padding:10px; border:1px solid #ddd;">Edit</th>
                <th style="padding:10px; border:1px solid #ddd;">Delete</th>
            </tr>

            <c:forEach var="user" items="${userList}">
                <tr>

                    <td style="padding:10px; border:1px solid #ddd;">${user.userId}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${user.userName}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${user.email}</td>

                    <td style="padding:10px; border:1px solid #ddd; text-align:center;">
                        <a href="updateUserPage?userId=${user.userId}"
                           style="padding:6px 10px; background:#e4e6eb; text-decoration:none; color:#2d2d2d; border-radius:5px;">
                            Edit
                        </a>
                    </td>

                    <td style="padding:10px; border:1px solid #ddd; text-align:center;">
                        <a href="deleteUser?userId=${user.userId}"
                           style="padding:6px 10px; background:#ff6b00; text-decoration:none; color:white; border-radius:5px;">
                            Delete
                        </a>
                    </td>

                </tr>
            </c:forEach>

        </table>

        <br/>

        <a href="addUser"
           style="padding:10px 15px; background:#ff6b00; color:white; text-decoration:none; border-radius:5px;">
            + Add User
        </a>

    </div>

</div>