import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RegisterView from "@/views/RegisterView";
import FindView from "@/views/FindView";
import AppIndex from "@/components/home/AppIndex";
import Login from "@/components/Login";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
    {
      path:"/login",
      name:'login',
      component: Login
    },
    {
      path:"/find",
      name:'find',
      component: FindView
    },
    {
        path:"/register",
        name:'register',
        component: RegisterView
    },
  {
    path:"/index",
    name:'index',
    component: AppIndex
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
