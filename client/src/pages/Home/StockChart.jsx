import { Button } from "@/components/ui/button";
import { useState } from "react";
import ReactApexChart from "react-apexcharts";

const timeSeries = [
  {
    keyword: "DIGITAL_CURRENCY_DAILY",
    key: "Time Series (Daily)",
    label: "1 Day",
    value: 1,
  },
  {
    keyword: "DIGITAL_CURRENCY_WEEKLY",
    key: "Time Series (Weekly)",
    label: "1 Week",
    value: 7,
  },
  {
    keyword: "DIGITAL_CURRENCY_MONTHLY",
    key: "Time Series (Monthly)",
    label: "1 Month",
    value: 30,
  },
];

const StockChart = () => {
  const [activeLabel, setActiveLabel] = useState("1 Day");

  const series = [
    {
      data: [
        [1717812278065, 69425.414716948],
        [1717816053092, 69409.1858152685],
        [1717819300297, 69392.7912077337],
        [1717822963195, 69308.1028434092],
        [1717826683656, 69288.1220231968],
        [1717830203232, 69308.1573604734],
        [1717833908989, 69503.4811469108],
        [1717837696542, 69391.1758718562],
        [1717840978248, 69422.0549280154],
        [1717844732397, 69432.2558812556],
        [1717848458538, 69258.7293089111],
        [1717851608613, 69337.6034185581],
        [1717855516749, 69410.6900283224],
        [1717859035212, 69443.1469916804],
        [1717862649888, 69405.6376346398],
        [1717866474312, 69361.4613443017],
        [1717869751984, 69439.9608949766],
        [1717873768142, 69487.7568986338],
        [1717877232839, 69449.8143796838],
        [1717880438142, 69359.7527351706],
        [1717884426542, 69396.2752952117],
        [1717888005832, 69311.0017020248],
        [1717891413502, 69305.3841323032],
        [1717894827248, 69271.8296736377],
        [1717898816451, 69294.7352566043],
        [1717902443316, 69189.2748458812],
        [1717905957332, 69255.1233602368],
        [1717909687671, 69268.8490765606],
        [1717912950889, 69301.4282640203],
        [1717916889328, 69402.313384699],
        [1717920276629, 69288.4038007093],
        [1717923836215, 69341.4154752407],
        [1717927328091, 69358.7594795781],
        [1717931275060, 69355.0540363074],
        [1717934702431, 69359.7705310153],
        [1717938040863, 69739.2548361805],
        [1717941879881, 69464.5472796116],
        [1717945312021, 69489.0226332393],
        [1717949327702, 69512.5859890188],
        [1717952710953, 69636.4479248663],
        [1717956121195, 69658.466811643],
        [1717959909279, 69737.1291933403],
        [1717963602926, 69649.068700276],
        [1717966839585, 69681.2350102205],
        [1717970913829, 69705.3147840307],
        [1717974091803, 69616.3120355403],
        [1717978020923, 69600.8459718684],
        [1717981399765, 69556.8263440378],
        [1717985043870, 69601.3025268636],
        [1717988659643, 69699.9044815104],
        [1717992182285, 69593.5074206439],
      ],
    },
  ];

  const options = {
    chart: {
      id: "area-datetime",
      type: "area",
      height: 350,
      zoom: {
        autoScaleYaxis: true,
      },
    },
    dataLabels: {
      enabled: false,
    },
    xaxis: {
      type: "datetime",
      tickAmount: 6,
    },
    colors: ["#758AA2"],
    markers: {
      colors: ["#fff"],
      strokeColor: "#fff",
      size: 0,
      strokeWidth: 1,
      style: "hollow",
    },
    tooltip: {
      theme: "dark",
    },
    fill: {
      type: "gradient",
      gradient: {
        shadeIntensity: 1,
        opacityFrom: 0.7,
        opacityTo: 0.9,
        stops: [0, 100],
      },
    },
    grid: {
      borderColor: "#47535E",
      strokeDashArray: 4,
      show: true,
    },
  };

  const handleActiveLabel = (value) => {
    setActiveLabel(value);
  };
  return (
    <div>
      <div className="space-x-3">
        {timeSeries.map((item) => (
          <Button
            variant={activeLabel == item.label ? "" : "outline"}
            onClick={() => handleActiveLabel(item.label)}
            key={item.label}
          >
            {item.label}
          </Button>
        ))}
      </div>
      <div id="chart-timelines">
        <ReactApexChart
          options={options}
          series={series}
          height={450}
          type="area"
        />
      </div>
    </div>
  );
};

export default StockChart;
