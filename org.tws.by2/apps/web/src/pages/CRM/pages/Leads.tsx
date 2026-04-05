import { Card } from "antd";

export function Leads() {
    return (

        <div className="p-4">
            <div className="grid grid-cols-3 gap-4">
                <Card title="Leads" style={{ borderRadius: 12 }} loading={true}>
  
                </Card>
                <Card title="Leads" style={{ borderRadius: 12 }} loading={true}>

                </Card>
                <Card title="Leads" style={{ borderRadius: 12 }} loading={true}>
                </Card>
            </div>
            <div className="mt-4">
                <Card title="Leads" loading={true}></Card>
            </div>
        </div>
    )
}