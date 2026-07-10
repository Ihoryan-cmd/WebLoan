# BUG-USR-003 — SQL error occurs when Phone Number exceeds the maximum allowed length

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-USR-003 |
| **Module** | User Management |
| **Severity** | Critical |
| **Priority** | High |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

Entering more than the maximum allowed number of digits into the **Phone Number** field and submitting the form causes an SQL error instead of displaying a validation message.

---

# Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**.
- The **Add User** page is open.

---

# Steps to Reproduce

1. Navigate to **Users**.
2. Click **Add User**.
3. Enter valid values into all required fields.
4. Enter more than **10 digits** into the **Phone Number** field.
5. Click **Save**.

---

# Actual Result

The application throws an SQL error after submitting the form.

---

# Expected Result

The application should validate the Phone Number field before processing the request.

A validation message should be displayed indicating that the Phone Number cannot exceed **10 digits**.

The form should not be submitted.

---

# Business Impact

- User creation process fails unexpectedly.
- Internal database exception is exposed to the end user.
- Missing server-side validation may compromise application stability.
- Users receive a system error instead of a meaningful validation message.

---

# Root Cause (Suspected)

The application submits data to the database without validating the maximum allowed length of the Phone Number field on the server side.

---

# Attachments

- Screenshot of the SQL error.
- Azure DevOps Bug #16

---