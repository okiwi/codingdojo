import App from "../App";
import React from "react";
import { render, fireEvent, cleanup } from "@testing-library/react";
import "jest-dom/extend-expect";

afterEach(cleanup);

describe("App", function() {
  it("starts with empty company", function() {
    const { getByTestId } = render(<App />);
    expect(getByTestId("harvest")).toHaveTextContent("0 lines of code");
  });

  it("creates one LOC when <1 writer> is clicked", function() {
    const { getByTestId } = render(<App />);
    writeOneLoc(getByTestId);
    expect(getByTestId("harvest")).toHaveTextContent("1 lines of code");
  });

  it("can buy 1 developer from 10 LOC", function() {
    const { getByTestId } = render(<App />);

    writeLocs(getByTestId, 10);

    expect(getByTestId("buy-1-dev")).toBeInTheDocument();
  });

  it("spends 10 LOC to buy 1 developer ", function() {
    const { getByTestId } = render(<App />);

    writeLocs(getByTestId, 12);
    expect(getByTestId("developers")).toHaveTextContent(/^0 DEV$/);

    fireEvent.click(getByTestId("buy-1-dev"));

    expect(getByTestId("harvest")).toHaveTextContent(/^2 lines of code/);
    expect(getByTestId("developers")).toHaveTextContent(/^1 DEV$/);
  });
});

function writeOneLoc(getByTestId) {
  writeLocs(getByTestId, 1);
}

function writeLocs(getByTestId, locCount) {
  for (let i = 0; i < locCount; i++)
    fireEvent.click(getByTestId("write-one-loc"));
}
