var _typeof = typeof Symbol === "function" && typeof Symbol.iterator === "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol === "function" && obj.constructor === Symbol ? "symbol" : typeof obj; };

define("frontend-js-metal-web@1.0.0/metal-tooltip/src/Tooltip", ['exports', './TooltipBase', 'metal-jquery-adapter/src/JQueryAdapter', './Tooltip.soy'], function (exports, _TooltipBase2, _JQueryAdapter) {
  'use strict';

  Object.defineProperty(exports, "__esModule", {
    value: true
  });

  var _TooltipBase3 = _interopRequireDefault(_TooltipBase2);

  var _JQueryAdapter2 = _interopRequireDefault(_JQueryAdapter);

  function _interopRequireDefault(obj) {
    return obj && obj.__esModule ? obj : {
      default: obj
    };
  }

  function _classCallCheck(instance, Constructor) {
    if (!(instance instanceof Constructor)) {
      throw new TypeError("Cannot call a class as a function");
    }
  }

  function _possibleConstructorReturn(self, call) {
    if (!self) {
      throw new ReferenceError("this hasn't been initialised - super() hasn't been called");
    }

    return call && ((typeof call === 'undefined' ? 'undefined' : _typeof(call)) === "object" || typeof call === "function") ? call : self;
  }

  function _inherits(subClass, superClass) {
    if (typeof superClass !== "function" && superClass !== null) {
      throw new TypeError("Super expression must either be null or a function, not " + typeof superClass);
    }

    subClass.prototype = Object.create(superClass && superClass.prototype, {
      constructor: {
        value: subClass,
        enumerable: false,
        writable: true,
        configurable: true
      }
    });
    if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass;
  }

  var Tooltip = function (_TooltipBase) {
    _inherits(Tooltip, _TooltipBase);

    function Tooltip() {
      _classCallCheck(this, Tooltip);

      return _possibleConstructorReturn(this, _TooltipBase.apply(this, arguments));
    }

    Tooltip.prototype.syncVisible = function syncVisible(visible) {
      this.element.style.opacity = visible ? 1 : '';

      _TooltipBase.prototype.syncVisible.call(this, visible);
    };

    return Tooltip;
  }(_TooltipBase3.default);

  Tooltip.prototype.registerMetalComponent && Tooltip.prototype.registerMetalComponent(Tooltip, 'Tooltip')
  Tooltip.Align = _TooltipBase3.default.Align;
  Tooltip.ELEMENT_CLASSES = 'tooltip';
  exports.default = Tooltip;

  _JQueryAdapter2.default.register('tooltip', Tooltip);
});
//# sourceMappingURL=Tooltip.js.map