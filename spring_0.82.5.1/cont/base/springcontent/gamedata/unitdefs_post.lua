--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

for name, ud in pairs(UnitDefs) do
  if (ud.description) then
    -- Fix the EE unit descriptions
    ud.description = string.gsub(ud.description, '^: ', '')
  end
end

--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
