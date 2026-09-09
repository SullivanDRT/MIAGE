output "admin-token" {
  value = nonsensitive(module.kubernetes-dashboard.admin-token)
}
