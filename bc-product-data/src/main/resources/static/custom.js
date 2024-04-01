function price_negative(value) {
  if (value.toString().includes("-")) {
    return value;
  }
  return "";
}

function comma_separator(value) {
  // Add comma for dollar format, i.e. 1,000,000
  return value.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
  //return value.replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");
}

function greetWorld(value) {
  alert("hello world" + value)
}