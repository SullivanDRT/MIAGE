output "admin-token" {
  value     = kubernetes_secret_v1.admin-user.data.token
  sensitive = true
}
