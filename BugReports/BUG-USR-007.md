# BUG-USR-006 — User can be created with an invalid email address

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-USR-006 |
| **Module** | User Management |
| **Severity** | Medium |
| **Priority** | Medium |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

The application allows creating a user with an invalid email address instead of validating the email format.

---

# Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**.
- The **Add User** page is open.

---

# Test Data

| Field | Value |
|------|------|
| Username | testuser01 |
| Password | Password123 |
| First Name | Ihor |
| Last Name | Tovt |
| Company | Novum |
| Phone Number | (201)005-4568 |
| Email | invalid-email |

---

# Steps to Reproduce

1. Navigate to **Users**.
2. Click **Add User**.
3. Populate all required fields with valid data.
4. Enter **invalid-email** into the **Email** field.
5. Click **Save**.

---

# Actual Result

The user is created successfully despite the Email field containing an invalid email format.

---

# Expected Result

The application should validate the Email field before creating the user.

A validation message indicating that the email address is invalid should be displayed.

The user should not be created until a valid email address is provided.

---

# Business Impact

- Invalid email addresses can be stored in the system.
- Email notifications may fail to reach users.
- Data quality and integrity are compromised.
- Missing input validation may affect downstream business processes.

---

# Root Cause (Suspected)

The Email field format is not validated on the server side before the user record is created.

---

# Attachments

- Screenshot demonstrating successful user creation with an invalid email address.
- Azure DevOps Bug #19

---