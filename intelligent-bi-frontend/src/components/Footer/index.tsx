import {GithubOutlined} from '@ant-design/icons';
import {DefaultFooter} from '@ant-design/pro-components';
import '@umijs/max';
import React from 'react';

const Footer: React.FC = () => {
  const defaultMessage = '知识星球个人学习项目';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: '个人主页',
          title: '个人主页',
          href: 'http://Daneliya.github.io',
          blankTarget: true,
        },
        {
          key: 'github',
          title: <GithubOutlined title='项目源码'/>,
          href: 'https://github.com/Daneliya/xubi',
          blankTarget: true,
        },
        // {
        //   key: '鱼智能 BI',
        //   title: '鱼智能 BI',
        //   href: 'https://ant.design',
        //   blankTarget: true,
        // },
      ]}
    />
  );
};
export default Footer;
