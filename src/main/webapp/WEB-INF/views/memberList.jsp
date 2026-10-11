<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"/>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:85%; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="color:#2d2d2d;">Group Members</h2>

        <table style="width:100%; border-collapse:collapse; margin-top:20px;">

            <tr style="background:#f1f2f6;">
                <th style="padding:10px; border:1px solid #ddd;">ID</th>
                <th style="padding:10px; border:1px solid #ddd;">Group</th>
                <th style="padding:10px; border:1px solid #ddd;">User</th>
                <th style="padding:10px; border:1px solid #ddd;">Amount</th>
                <th style="padding:10px; border:1px solid #ddd;">Edit</th>
                <th style="padding:10px; border:1px solid #ddd;">Delete</th>
            </tr>

            <c:forEach var="m" items="${memberList}">
                <tr>

                    <td style="padding:10px; border:1px solid #ddd;">${m.gmId}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${groupMap[m.groupId]}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${userMap[m.userId]}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${m.amountCollected}</td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="updateMemberPage?gmId=${m.gmId}"
                           style="padding:6px 10px; background:#e4e6eb; text-decoration:none; color:#2d2d2d; border-radius:5px;">
                            Edit
                        </a>
                    </td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="deleteMember?gmId=${m.gmId}"
                           style="padding:6px 10px; background:#ff6b00; text-decoration:none; color:white; border-radius:5px;">
                            Delete
                        </a>
                    </td>

                </tr>
            </c:forEach>

        </table>

        <br/>

        <a href="memberForm"
           style="padding:10px 15px; background:#ff6b00; color:white; text-decoration:none; border-radius:5px;">
            + Add Member
        </a>

    </div>

</div>