module "kind-cluster" {
  source              = "./modules/kind-cluster"
  cluster-name        = var.cluster-name
  kubeconfig_filepath = var.kubeconfig_filepath
}

resource "local_sensitive_file" "kubeconfig" {
  depends_on = [module.kind-cluster]
  content    = module.kind-cluster.kubeconfig
  filename   = ".kube/kindconfig"
}

module "nginx-ingress" {
  depends_on              = [local_sensitive_file.kubeconfig]
  source                  = "./modules/nginx-ingress"
  ingress_nginx_namespace = var.ingress_nginx_namespace
  kubeconfig_content      = module.kind-cluster.kubeconfig
}

module "kubernetes-dashboard" {
  depends_on                = [module.nginx-ingress]
  source                    = "./modules/kubernetes-dashboard"
  kubernetes-dashboard-name = var.kubernetes-dashboard-name
  app-selector              = var.app-selector
}
