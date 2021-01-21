-- |

module AOCSpec where

import Test.Hspec

type Map = [String]

data Step = Step Int Int
  deriving (Eq, Show)

countTrees :: Map -> Step -> Int
countTrees [_, line] _ = length (filter (== '#') line)
countTrees _ _ = undefined

data Map'

type Position = (Int,Int)

atEndOfMap :: Position -> Map' -> Bool
atEndOfMap = undefined

moveTo :: Position -> Step -> Position
moveTo (x,y) (Step r c) = undefined

countTrees' :: Map' -> Step -> Int
countTrees' map' step =
  snd $ jump step map' ((0,0),0)

thereIsATreeAt :: Position -> Map' -> Bool
thereIsATreeAt = undefined

jump :: Step -> Map' -> (Position, Int) -> (Position, Int)
jump _ map' (pos, count) | atEndOfMap pos map' = (pos, count)
jump step map' (pos, count) =
  let newPosition = moveTo pos step
  in if thereIsATreeAt newPosition map' then
       jump step map' (newPosition, count + 1)
     else
       jump step map' (newPosition, count)

spec :: Spec
spec = describe "AOC Day 3" $ do
  it "detects a tree on a map with step 1,1" $ do
     let simpleMap = [ "..",
                 ".#"
               ]
         step = Step 1 1

     countTrees simpleMap step `shouldBe` 1

  it "does not detect with step 1,1" $ do
    let singleMap = [".."
                    ,".."]
        step = Step 1 1

    countTrees singleMap step `shouldBe` 0
