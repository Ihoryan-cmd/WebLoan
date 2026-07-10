# BUG-USR-004 — Cancel button does not navigate back to the Users page

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-USR-004 |
| **Module** | User Management |
| **Severity** | Medium |
| **Priority** | Medium |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

Clicking the **Cancel** button on the **Add User** page does not navigate the user back to the **Users** page.

---

# Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**.
- The **Add User** page is open.

---

# Steps to Reproduce

1. Navigate to **Users**.
2. Click **Add User**.
3. Click the **Cancel** button.

---

# Actual Result

Nothing happens after clicking the **Cancel** button.

The user remains on the **Add User** page.

---

# Expected Result

The application should navigate the user back to the **Users** page.

Any unsaved changes should be discarded.

---

# Business Impact

- Users cannot cancel the current operation.
- Additional navigation is required to leave the page.
- The application behaves inconsistently with standard UI conventions.

---

# Root Cause (Suspected)

The **Cancel** button is not bound to its navigation action or the corresponding event handler is not executed.

---

# Attachments

- Screenshot demonstrating the issue.
- Azure DevOps Bug #20

---