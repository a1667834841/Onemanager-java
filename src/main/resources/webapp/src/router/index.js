import Vue from 'vue'
import Router from 'vue-router'
import Layout from '@/views/Layout'
import Table from '@/components/Table'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Layout',
      component: Layout
    },
    {
      path: '/table',
      name: 'Table',
      component: Table
    },
    {
      path: '/layout',
      name: 'Layout',
      component: Layout
    },
  ]
})
