from constantList_KP4_1 import *
from pp import *

# open the Prog&Play API
PP_Open()
# set target position
pos = PP_Pos(100.0, 100.0)
# iterate all units
i = 0
while i < PP_GetNumUnits(MY_COALITION):
    # get current unit
    u = PP_GetUnitAt(MY_COALITION, i)
    # give a Move order
    PP_Unit_ActionOnPosition(u, MOVE, pos)
    i += 1
# close the Prog&Play API
PP_Close()
