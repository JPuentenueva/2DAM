# -*- coding: utf-8 -*-
from openerp import models, fields

class Prenda (models.Model):
 _name= "lavanderia.prenda"
 nombre = fields.Char("Nombre prenda", required=True)
 color = fields.Char("Color")
 talla = fields.Char("Talla", default=True)