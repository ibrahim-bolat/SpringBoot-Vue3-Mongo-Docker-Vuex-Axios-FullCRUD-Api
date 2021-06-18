import { createRouter, createWebHistory } from 'vue-router'
import Anasayfa from '../views/Anasayfa'
import Hakkinda from '../views/Hakkinda'
import Deneme from '../views/Deneme'

const routes = [
  {
    path: '/',
    name: 'Anasayfa',
    component: Anasayfa
  },
  {
    path: '/hakkinda',
    name: 'Hakkinda',
    component:Hakkinda
  },
  {
    path: '/deneme',
    name: 'Deneme',
    component:Deneme
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
