# BUG-USR-005 — Branch Role dropdown is missing on the Add User page

## Bug Information

| Property | Value |
|----------|-------|
| **Bug ID** | BUG-USR-005 |
| **Module** | User Management |
| **Severity** | Medium |
| **Priority** | Medium |
| **Status** | Open |
| **Reported By** | Ihor Tovt |
| **Environment** | SmartBank LoanApp (QA Environment) |

---

# Summary

The **Branch Role** dropdown is not displayed on the **Add User** page, preventing users from assigning a role during user creation.

---

# Preconditions

- User is logged in as **Administrator**.
- Branch: **Halifax**.
- The **Add User** page is open.

---

# Steps to Reproduce

1. Navigate to **Users**.
2. Click **Add User**.
3. Observe the page layout.

---

# Actual Result

The **Branch Role** dropdown is not displayed on the **Add User** page.

---

# Expected Result

The **Branch Role** dropdown should be displayed and available for selecting a user role before saving the new user.

---

# Business Impact

- Users cannot assign roles during user creation.
- User creation workflow is incomplete.
- Missing UI element may prevent correct user configuration.

---

# Root Cause (Suspected)

The **Branch Role** dropdown is either not rendered in the UI or is not loaded due to an application or frontend issue.

---

# Attachments

- Screenshot showing the missing **Branch Role** dropdown.
- Azure DevOps Bug #12

---