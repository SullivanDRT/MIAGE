resource "helm_release" "ingress_nginx" {
  name       = "ingress-nginx"
  repository = "https://kubernetes.github.io/ingress-nginx"
  chart      = "ingress-nginx"
  version    = "4.13.3"

  namespace        = var.ingress_nginx_namespace
  create_namespace = true

  values = [file("${path.module}/nginx_ingress_values.yaml")]
}

resource "local_sensitive_file" "kubeconfig" {
  content  = var.kubeconfig_content
  filename = ".kube/kindconfig"
}

resource "null_resource" "wait_for_ingress_nginx" {
  triggers = {
    key = uuid()
  }

  provisioner "local-exec" {
    command = <<EOF
      printf "\nWaiting for the nginx ingress controller...\n"
      kubectl wait --namespace ${helm_release.ingress_nginx.namespace} \
        --kubeconfig="${local_sensitive_file.kubeconfig.filename}" \
        --for=condition=ready pod \
        --selector=app.kubernetes.io/component=controller \
        --timeout=90s
    EOF
  }

  depends_on = [
    helm_release.ingress_nginx,
    local_sensitive_file.kubeconfig
  ]
}
