variable "cluster-name" {
  type    = string
  default = "local-cluster"
}

variable "kubeconfig_filepath" {
  type    = string
  default = ".kube/config"
}

variable "kubernetes-dashboard-name" {
  type    = string
  default = "kubernetes-dashboard"
}

variable "app-selector" {
  type    = string
  default = "k8s-app"
}

variable "ingress_nginx_namespace" {
  type    = string
  default = "ingress-nginx"
}