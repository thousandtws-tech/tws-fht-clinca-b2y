import { Card } from "antd";



export function Dashboard() {
    return (

        <div className="p-4">
            <div className="grid grid-cols-3 gap-4">
                <Card title="Dashboard" style={{ borderRadius: 12 }} loading={true}>
  
                </Card>
                <Card title="Dashboard" style={{ borderRadius: 12 }} loading={true}>

                </Card>
                <Card title="Dashboard" style={{ borderRadius: 12 }} loading={true}>
                </Card>
            </div>
            <div className="mt-4">
                <Card title="Dashboard" loading={true}></Card>
            </div>
        </div>
    )
}