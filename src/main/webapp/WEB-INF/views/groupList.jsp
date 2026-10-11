<jsp:include page="header.jsp"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="padding:100px 30px; background:#f5f6fa; min-height:100vh;">

    <div style="width:90%; margin:auto; background:white; padding:25px; border-radius:10px; box-shadow:0 3px 10px rgba(0,0,0,0.08);">

        <h2 style="color:#2d2d2d;">Group List</h2>

        <table style="width:100%; border-collapse:collapse; margin-top:20px;">

            <tr style="background:#f1f2f6;">
                <th style="padding:10px; border:1px solid #ddd;">ID</th>
                <th style="padding:10px; border:1px solid #ddd;">Name</th>
                <th style="padding:10px; border:1px solid #ddd;">Created By</th>
                <th style="padding:10px; border:1px solid #ddd;">Start</th>
                <th style="padding:10px; border:1px solid #ddd;">End</th>
                <th style="padding:10px; border:1px solid #ddd;">Amount</th>
                <th style="padding:10px; border:1px solid #ddd;">Edit</th>
                <th style="padding:10px; border:1px solid #ddd;">Delete</th>
                <th style="padding:10px; border:1px solid #ddd;">Summary</th>
            </tr>

            <c:forEach var="g" items="${groupList}">
                <tr>

                    <td style="padding:10px; border:1px solid #ddd;">${g.groupId}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${g.groupName}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${g.createdBy}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${g.startDate}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${g.endDate}</td>
                    <td style="padding:10px; border:1px solid #ddd;">${g.initialAmount}</td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="updateGroupPage?groupId=${g.groupId}"
                           style="padding:6px 10px; background:#e4e6eb; text-decoration:none; color:#2d2d2d; border-radius:5px;">
                            Edit
                        </a>
                    </td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="deleteGroup?groupId=${g.groupId}"
                           style="padding:6px 10px; background:#ff6b00; text-decoration:none; color:white; border-radius:5px;">
                            Delete
                        </a>
                    </td>

                    <td style="text-align:center; border:1px solid #ddd;">
                        <a href="summary?groupId=${g.groupId}"
                           style="padding:6px 10px; background:#2d2d2d; text-decoration:none; color:white; border-radius:5px;">
                            View
                        </a>
                    </td>

                </tr>
            </c:forEach>

        </table>

        <br/>

        <a href="groupForm"
           style="padding:10px 15px; background:#ff6b00; color:white; text-decoration:none; border-radius:5px;">
            + Add Group
        </a>

    </div>

</div>