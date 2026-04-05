import { Layout } from "antd";

import { Outlet } from "react-router-dom";

import { Sidebar } from "../Sidebar/Sidebar";
import { HeaderBar } from "../HeaderBar/HeaderBar";

const { Sider, Header, Content } = Layout;

export function AppLayout() {

  return (
    <Layout style={{ minHeight: "100vh" }}>

      <Sider>
        <Sidebar/>
      </Sider>

      <Layout>
        <Header style={{ background: "#fff", padding: "0"}} >
          <HeaderBar />
        </Header>

        <Content>
          <Outlet />
        </Content>

      </Layout>

    </Layout>
  );
}