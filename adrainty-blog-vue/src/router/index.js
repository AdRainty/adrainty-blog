import Vue from 'vue'
import Router from 'vue-router'
import index from '@/components/index'
import archives from '@/components/archives'
import tags from '@/components/tags'
import types from '@/components/types'
import blog from '@/components/blog'
import chat from '@/components/chat'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    },
		{
			path: '/index',
			name: 'index',
			component: index
		},
		{
		  path: '/archives',
		  name: 'archives',
		  component: archives
		},
		{
		  path: '/tags',
		  name: 'tags',
		  component: tags
		},
		{
		  path: '/types',
		  name: 'types',
		  component: types
		},
		{
			path: '/blog',
			name: 'blog',
			component: blog
		},
		{
			path: '/chat',
			name: 'chat',
			component: chat
		}
  ]
})
