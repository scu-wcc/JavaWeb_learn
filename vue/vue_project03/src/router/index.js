import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [
  //重定位
  {
    path: '/',
    redirect: '/myView'
  },
  {
    path: '/MyView',
    name: 'MyView',
    component: () => import( '../views/Element/MyView.vue')
  },
  {
    path: '/OtherView',
    name: 'OtherView',
    component: () => import( '../views/Element/OtherView.vue')
  }


]

const router = new VueRouter({
  routes
})

export default router
