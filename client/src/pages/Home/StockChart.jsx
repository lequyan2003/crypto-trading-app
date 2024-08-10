import { Button } from "@/components/ui/button";
import { fetchMarketChart } from "@/State/Coin/Action";
import { useEffect, useState } from "react";
import ReactApexChart from "react-apexcharts";
import { useDispatch, useSelector } from "react-redux";

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
  {
    keyword: "DIGITAL_CURRENCY_YEARLY",
    key: "Time Series (Yearly)",
    label: "1 Year",
    value: 365,
  },
];

// eslint-disable-next-line react/prop-types
const StockChart = ({ coinId }) => {
  const dispatch = useDispatch();
  const { coin } = useSelector(store => store);

  const [activeLabel, setActiveLabel] = useState(timeSeries[0]);

  const series = [
    {
      data: coin.marketChart.data,
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

  useEffect(() => {
    dispatch(fetchMarketChart({ coinId, days: activeLabel.value, jwt: localStorage.getItem("jwt") }))
  }, [dispatch, coinId, activeLabel]);
  return (
    <div>
      <div className="space-x-3">
        {timeSeries.map((item) => (
          <Button
            variant={activeLabel.label == item.label ? "" : "outline"}
            onClick={() => handleActiveLabel(item)}
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
