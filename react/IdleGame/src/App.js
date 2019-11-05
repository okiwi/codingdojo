import React, { Component } from "react";
import "./App.css";

class App extends Component {
  state = {
    productionCode: 0,
    developers: { count: 0 }
  };

  render() {
    const { productionCode, developers } = this.state;

    return (
      <div className="App">
        <div className="actions">
          <button
            data-testid="write-one-loc"
            onClick={() => this.writeOneLoc()}
          >
            Write 1 line of code
          </button>
          {productionCode >= 10 && (
            <button
              data-testid="buy-1-dev"
              onClick={() => {
                this.buyOneDev();
              }}
            >
              Buy 1 DEV
            </button>
          )}
        </div>
        <div data-testid="harvest">{productionCode} lines of code</div>

        <div data-testid="developers">{developers.count} DEV</div>
      </div>
    );
  }

  writeOneLoc() {
    this.setState({ productionCode: this.state.productionCode + 1 });
  }

  buyOneDev() {
    this.setState({
      productionCode: this.state.productionCode - 10,
      developers: { count: this.state.developers.count + 1 }
    });
  }
}

export default App;
