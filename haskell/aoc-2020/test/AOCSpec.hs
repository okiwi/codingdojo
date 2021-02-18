-- |

module AOCSpec where

import Test.Hspec
import Test.QuickCheck

-- --type Map = [String]

data Step = Step Int Int
  deriving (Eq, Show)

-- ---countTrees :: Map -> Step -> Int
-- -countTrees [_, line] _ = length (filter (== '#') line)
-- countTrees _ _ = undefined

data Map' = Map' { cols :: Int, rows :: Int, theMap :: [[Int]] }
  deriving (Eq, Show)

instance Arbitrary Map' where
  arbitrary = do
    c <- choose (1,100)
    r <- choose (1,100)
    t <- trees c r
    pure $ Map' c r t

trees :: Int -> Int -> Gen [[Int]]
trees c r = undefined

encodePuzzle :: Map' -> [String]
encodePuzzle (Map' c r _) = replicate r $ replicate c '.'

decodePuzzle :: [String] -> Map'
decodePuzzle (p : puzzle) =
  let cols' = length p
      lines' = length puzzle + 1
  in Map' cols' lines' (replicate lines' [])

decodePuzzle _ = Map' 11 2 [[2,3],[0,4,8]]

type Position = (Int,Int)

atEndOfMap :: Position -> Map' -> Bool
atEndOfMap (x,_) (Map' _ r _) = x >= r-1

moveTo :: Position -> Step -> Map' -> Position
moveTo (x,y) (Step a b) (Map' c _ _) = (x+a, (y+b) `mod` c)

-- | Assumes x < rows, y < cols
thereIsATreeAt :: Position -> Map' -> Bool
thereIsATreeAt (x,y) (Map' _ _ trees) = y `elem` trees !! x

jump :: Step -> Map' -> (Position, Int) -> (Position, Int)
jump _ map' (pos, count) | atEndOfMap pos map' = (pos, count)
jump step map' (pos, count) =
  let newPosition = moveTo pos step map'
  in if thereIsATreeAt newPosition map' then
       jump step map' (newPosition, count + 1)
     else
       jump step map' (newPosition, count)

countTrees' :: Map' -> Step -> Int
countTrees' map' step =
  snd $ jump step map' ((0,0),0)

spec :: Spec
spec = describe "AOC Day 3" $ do
  describe "At end of map" $ do
    it "detecs a tree on our new map" $ do
      let map' = Map' 2 2 [[0],[]]
      thereIsATreeAt (0,0) map' `shouldBe` True

    it "doesn't detect a tree on an empty map" $ do
      let map' = Map' 2 2 [[],[]]
      thereIsATreeAt (1,1) map' `shouldBe` False

    it "isn't at end of map if not on last line" $ do
      let map' = Map' 2 2 [[],[]]
      atEndOfMap (0,0) map' `shouldBe` False

    it "is at end of map if on last line" $ do
      let map' = Map' 2 2 [[], []]
      atEndOfMap (1,0) map' `shouldBe` True

    it "is after the end of map" $ do
      let map' = Map' 2 2 [[],[]]
      atEndOfMap (3,1) map' `shouldBe` True

    it "moves 1 col/1 row given a step/position/map" $ do
      let map' = Map' 2 2 [[],[]]
      moveTo (0,0) (Step 1 1) map' `shouldBe` (1,1)

    it "wraps column when moving past last column" $ do
      let map' = Map' 2 2 [[],[]]
      moveTo (1,1) (Step 1 1) map' `shouldBe` (2,0)


  it "detects a tree on a map with step 1,1" $ do
    let simpleMap = Map' 2 2 [[],[1]]
        step = Step 1 1

    countTrees' simpleMap step `shouldBe` 1

  it "does not detect with step 1,1" $ do
    let singleMap = Map' 2 2 [[],[]]
        step = Step 1 1

    countTrees' singleMap step `shouldBe` 0

  it "decode input puzzle" $ do
    let inputPuzzle = [ "..##......."
                      , "#...#...#.."
                      ]

    decodePuzzle inputPuzzle `shouldBe` Map' 11 2 [[2,3],[0,4,8]]

  it "decode another input puzzle" $ do
    let inputPuzzle = [ "..." ]

    decodePuzzle inputPuzzle `shouldBe` Map' 3 1 [[]]

  it "encode and decode puzzle" $ property roundTripMapEncoding

roundTripMapEncoding :: Map' -> Property
roundTripMapEncoding map' =
  let encoded = encodePuzzle map'
      decoded = decodePuzzle encoded
  in counterexample ("encoded: " <> show encoded <> ", decode: " <> show decoded) $ decoded == map'

{--

..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#

--}
