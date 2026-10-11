
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dashboard</title>
</head>

<body style="margin:0; font-family:'Segoe UI', Arial; background-color:#f5f6fa;">

<!-- HEADER -->
<div style="
    position:sticky;
    top:0;
    z-index:1000;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px 40px;
    background:white;
    box-shadow:0 2px 6px rgba(0,0,0,0.05);
">

    <div style="font-size:20px; font-weight:600; color:#2d2d2d;">
        Travel Expense System
    </div>

    <div style="font-size:14px; color:#777;">
        Dashboard
    </div>

</div>


<!-- HERO SECTION WITH IMAGE -->
<div style="
    margin:30px auto;
    width:85%;
    height:260px;
    border-radius:15px;
    overflow:hidden;
    position:relative;
">

    <!-- BACKGROUND IMAGE -->
    <div style="
        position:absolute;
        width:100%;
        height:100%;
        background-image: url('${pageContext.request.contextPath}/resources/images/bg.png');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
    "></div>

    <!-- DARK OVERLAY -->
    <div style="
        position:absolute;
        width:100%;
        height:100%;
        background: rgba(20,20,20,0.55);
    "></div>

    <!-- CONTENT -->
    <div style="
        position:relative;
        z-index:2;
        height:100%;
        display:flex;
        flex-direction:column;
        justify-content:center;
        align-items:center;
        color:white;
        text-align:center;
    ">

        <h1 style="margin-bottom:10px; font-weight:600;">Travel Management</h1>

        <p style="color:#e0e0e0;">
            Manage users, groups, members and expenses in one place
        </p>

    </div>

</div>


<!-- MAIN CONTENT -->
<div style="width:85%; margin:auto;">

    <div style="
        display:flex;
        flex-wrap:wrap;
        gap:25px;
        justify-content:center;
    ">

        <!-- USER MODULE -->
        <div style="
            background:white;
            width:240px;
            padding:25px;
            border-radius:12px;
            box-shadow:0 3px 10px rgba(0,0,0,0.08);
            text-align:center;
        ">

            <h3 style="color:#2d2d2d;">User Module</h3>

            <a href="addUser" style="
                display:block;
                margin:12px 0;
                padding:10px;
                background:#ff6b00;
                color:white;
                text-decoration:none;
                border-radius:6px;
            ">
                Add User
            </a>

            <a href="viewUsers" style="
                display:block;
                padding:10px;
                background:#e4e6eb;
                color:#2d2d2d;
                text-decoration:none;
                border-radius:6px;
            ">
                View Users
            </a>
        </div>


        <!-- GROUP MODULE -->
        <div style="
            background:white;
            width:240px;
            padding:25px;
            border-radius:12px;
            box-shadow:0 3px 10px rgba(0,0,0,0.08);
            text-align:center;
        ">

            <h3 style="color:#2d2d2d;">Group Module</h3>

            <a href="groupForm" style="
                display:block;
                margin:12px 0;
                padding:10px;
                background:#ff6b00;
                color:white;
                text-decoration:none;
                border-radius:6px;
            ">
                Create Group
            </a>

            <a href="viewGroups" style="
                display:block;
                padding:10px;
                background:#e4e6eb;
                color:#2d2d2d;
                text-decoration:none;
                border-radius:6px;
            ">
                View Groups
            </a>
        </div>


        <!-- MEMBER MODULE -->
        <div style="
            background:white;
            width:240px;
            padding:25px;
            border-radius:12px;
            box-shadow:0 3px 10px rgba(0,0,0,0.08);
            text-align:center;
        ">

            <h3 style="color:#2d2d2d;">Member Module</h3>

            <a href="memberForm" style="
                display:block;
                margin:12px 0;
                padding:10px;
                background:#ff6b00;
                color:white;
                text-decoration:none;
                border-radius:6px;
            ">
                Add Member
            </a>

            <a href="viewMembers" style="
                display:block;
                padding:10px;
                background:#e4e6eb;
                color:#2d2d2d;
                text-decoration:none;
                border-radius:6px;
            ">
                View Members
            </a>
        </div>


        <!-- EXPENSE MODULE -->
        <div style="
            background:white;
            width:240px;
            padding:25px;
            border-radius:12px;
            box-shadow:0 3px 10px rgba(0,0,0,0.08);
            text-align:center;
        ">

            <h3 style="color:#2d2d2d;">Expense Module</h3>

            <a href="expenseForm" style="
                display:block;
                margin:12px 0;
                padding:10px;
                background:#ff6b00;
                color:white;
                text-decoration:none;
                border-radius:6px;
            ">
                Add Expense
            </a>

            <a href="viewExpenses" style="
                display:block;
                padding:10px;
                background:#e4e6eb;
                color:#2d2d2d;
                text-decoration:none;
                border-radius:6px;
            ">
                View Expenses
            </a>
        </div>

    </div>

</div>

</body>
</html>

