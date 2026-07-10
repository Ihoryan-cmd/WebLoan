# Bug Report

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-USR-001 |
| **Module** | User Management |
| **Severity** | Critical |
| **Priority** | High |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

Creating a user while providing only the **Username** field results in an SQL error instead of displaying a validation message for the required **Password** field.

---

# Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**.
- The **Add User** page is open.

---

# Steps to Reproduce

1. Navigate to **Users**.
2. Click **Add User**.
3. Enter a valid value into the **Username** field.
4. Leave the **Password** field empty.
5. Leave all remaining fields empty.
6. Click **Save**.

---

# Actual Result

The application throws an SQL error instead of validating the required Password field.

---

# Expected Result

The application should prevent form submission and display the validation message:

> **"The 'Password' field is required."**

No SQL exception should occur.

---

# Business Impact

- User creation process is interrupted.
- Internal database error is exposed to the end user.
- Required field validation is bypassed.
- Indicates missing server-side input validation.

---

# Root Cause (Suspected)

The application attempts to execute the database operation before validating that all required fields have been provided.

---

# Attachments

- Screenshot of the SQL error
- Azure DevOps Bug #14

---